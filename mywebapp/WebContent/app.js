var x = 10;
var y = "a";

console.log(isNaN(x));
console.log(isNaN(y));

function validate(){
    var name = document.getElementById("name").value;
    console.log(name);
    if(  name.trim() == "" ){
        var ajax = new XMLHttpRequest();
        var text = ajax.onreadystatechange = function(){
            if(ajax.readyState == 4 && ajax.status == 200){
            document.getElementById("nameMsg").innerHTML=ajax.responseText;
        document.getElementById("nameMsg").style.backgroundColor = 'pink';
          }  }
        ajax.open("GET","test.txt",true);
        ajax.send();
        return false;
    }
    return true;
}