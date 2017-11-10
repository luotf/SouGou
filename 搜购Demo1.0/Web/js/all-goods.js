$(function(){
    var edi=$('.editor');
    var yes=$('.delete .yes');
    var no=$('.delete .no');
    var del=$('.delete');
    var succ=$('.success');
    var com=$('.success .comfirm');
    var dim=$('.dim');
    yes.click(function(){
       succ.css({
           display:'block'
       })
    })
    no.click(function(){
       del.css({
           display:'none'
       })
        dim.css({
            display:'none'
        })
    })
    edi.click(function(){
        del.css({
            display:'block'
        })
        dim.css({
            display:'block'
        })
    })
    com.click(function(){
        del.css({
            display:'none'
        })
        succ.css({
            display:'none'
        })
        dim.css({
            display:'none'
        })
    })
})
