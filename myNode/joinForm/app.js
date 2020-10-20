var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var join = require('./routes/joinForm');
var board = require('./routes/board');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({
    extended: false
}));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/join', join);
app.use('/board', board);
app.use(express.static('public'));
// catch 404 and forward to error handler
app.use(function (req, res, next) {
    next(createError(404));
});

// error handler
app.use(function (err, req, res, next) {
    // set locals, only providing error in development
    res.locals.message = err.message;
    res.locals.error = req.app.get('env') === 'development' ? err : {};

    // render the error page
    res.status(err.status || 500);
    res.render('error');
});

const multer  = require('multer');

const upload = multer({
  storage: multer.diskStorage({
    destination: function (req, file, cb) {
      cb(null, 'public/images/');
    },
    filename: function (req, file, cb) {
      console.log(file);
      cb(null,` ${new Date().valueOf()}_${file.originalname}`);
    }
  }),
});

app.use('/images',express.static('public/images'));

app.post('/images', upload.single('image'), (req, res) => {
  console.log(req.file);
  console.log(req.file.filename);
 // console.log(req.body);
 return res.status(200).json({name: req.file.filename});
})

app.get('/images', function(req, res){
    fs.readFile('req.body.image', function(error, data){
        res.write(200, {'Content-Type': 'text/html'});
        res.end(data);
    });
});

module.exports = app;
