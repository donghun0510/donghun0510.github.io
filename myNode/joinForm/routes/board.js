var express = require('express');
var router = express.Router();
// MySQL 로드
var mysql = require('mysql');
var pool = mysql.createPool({
    connectionLimit: 5,
    host: 'localhost',
    user: 'root',
    database: 'tutorial',
    password: '950510'
});

/* GET user listing. */
router.get('/', function (req, res, next) {
    // 그냥 board/ 로 접속할 경우 전체 목록 표시로 리다이렉팅
    res.redirect('/board/list/1');
});

router.get('/list/:page', function (req, res, next) {

    pool.getConnection(function (err, connection) {
        // Use the connection
        var sqlForSelectList = "SELECT idx, creator_id, title, hit FROM board";
        connection.query(sqlForSelectList, function (err, rows) {
            if (err) {
                console.error("err : " + err);
            }
            console.log("rows : " + JSON.stringify(rows));

            res.render('list', {
                title: ' 게시판 전체 글 조회',
                rows: rows
            });

            // Don't use the connection here, it ha been returned to the pool.
        });
    });
});
//글쓰기 화면 표시 GET
router.get('/write', function (req, res, next) {
    res.render('write', {
        title: "게시판 글 쓰기"
    });
    connection.release();
});
// 글쓰기 로직 처리 POST
router.post('/write', function (req, res, next) {

    var creator_id = req.body.creator_id;
    var title = req.body.title;
    var content = req.body.content;
    var passwd = req.body.passwd;
    var image = req.body.image;
    var datas = [creator_id, title, content, passwd, image];

    pool.getConnection(function (err, connection) {
        // Use the connection
        var sqlForInsertBoard = "insert into board(creator_id, title, content, passwd,image) values(?, ?, ?, ?, ?)";
        connection.query(sqlForInsertBoard, datas, function (err, rows) {
            if (err) {
                console.error("err : " + err);
            }
            console.log("rows : " + JSON.stringify(rows));

            // Don't use the connection here, it ha been returned to the pool.
        });
    });
});
// 글조회 로직 처리 GET
router.get('/read/:idx', function (req, res, next) {
    var idx = req.params.idx;
    var image = req.body.image;
    pool.getConnection(function (err, connection) {
        // Use the connection
        var sql = "select idx, creator_id, title, content, hit, image from board where idx=?";
        connection.query(sql, [idx], function (err, row) {
            if (err) {
                console.error(err);
            }
            console.log("1개 글 조회 결과 확인 : ", row);
            res.render('read', {
                title: "글 조회",
                row: row[0],
                image: image
            });
        });
    });
});
// 글수정 화면 표시 GET
router.get('/update', function (req, res, next) {
    var idx = req.query.idx;

    pool.getConnection(function (err, connection) {
        if (err) {
            console.error("커넥션 객체 얻어오기 에러 : ", err);
        }
        var sql = "select idx, creator_id, title, content, hit from board where idx=?";
        connection.query(sql, [idx], function (err, rows) {
            if (err) {
                console.error(err);
            }
            console.log("update에서 1개 글 조회 결과 확인 : ", rows);
            res.render('update', {
                title: "글 수정",
                row: rows[0]
            });
            connection.release();
        });
    });
});
// 글수정 로직 처리 POST
router.post('/update', function (req, res, next) {

    var idx = req.body.idx;
    var creator_id = req.body.creator_id;
    var title = req.body.title;
    var content = req.body.content;
    var passwd = req.body.passwd;
    var datas = [creator_id, title, content, passwd];

    pool.getConnection(function (err, connection) {
        var sql = "update board set creator_id=?, title=?, content=? where idx=? and passwd=?";
        connection.query(sql, [creator_id, title, content, idx, passwd], function (err, result) {
            console.log(result);
            if (err) {
                console.error("글 수정 중 에러 발생 err : ", err);
            }

            if (result.affectedRows == 0) {
                res.send("<script>alert('패스워드가 일치하지 않거나, 잘못된 요청으로 인해 값이 변경되지 않았습니다.');history.back();</script>");
            } else {
                res.redirect('/board/read/' + idx);
            }
            connection.release();
        });
    });
});

module.exports = router;
