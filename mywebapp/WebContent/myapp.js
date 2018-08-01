function validate(){
    if(document.getElementById("user").value){
        return true;
    }else{
        document.getElementById("err").innerHTML="User needed!";
        document.getElementById("err").style.color="red";
        //document.forms["f1"].submit()
        return false;
    }
}