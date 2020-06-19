// array, object

var f = function(){
  console.log(1+1);
  console.log(1+2);
}
console.log(f);
var a = [f];
a[0](); // function f call

var o = {
  func:f
}
o.func();
// var i = if(true){console.log(1)};

//var w = while(true){console.log(1);
