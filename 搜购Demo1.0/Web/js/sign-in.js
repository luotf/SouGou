
$(function(){
    /*var username=$(".main .sign_box .account");
    var pwd= $(".main .sign_box .psw");
    $(".main .sign_box .sign").click(function(){
        if(username.val()=='admin' && pwd.val()=='admin'){
            window.open('../admin/shop-admin.html');
        }
        else{
            alert("Erreurs password!");
        }
    })
*/
    username.focus(function(){
        $(this).css({
            background:"url('../images/icon/account_1.png') no-repeat 2px center"
        })
    })
    username.blur(function(){
        $(this).css({
            background:"url('../images/icon/account.png') no-repeat 2px center"
        })
    })
    pwd.focus(function(){
        $(this).css({
            background:"url('../images/icon/psw_1.png') no-repeat 2px center"
        })
    })
   pwd.blur(function(){
        $(this).css({
            background:"url('../images/icon/psw.png') no-repeat 2px center"
        })
    })
})
