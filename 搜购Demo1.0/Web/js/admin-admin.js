/**
 * Created by Mr.Wang on 2017/5/3.
 */

$(function(){
    $('.menu .first-menu').addClass('hasbg');
    $('.menu .first-menu').on('click',function(){
    if($(this).hasClass('hasbg')) {
        $(this).addClass('nobg').removeClass('hasbg');
    }
        else{
        $(this).addClass('hasbg').removeClass('nobg');
    }
    })

    $('.menu #first-menu1').on('click',function(){
        $('.menu .admin').slideToggle(500);
    })
    $('.menu #first-menu2').on('click',function(){
        $('.menu .user').slideToggle(500);
    })
    $('.menu #first-menu3').on('click',function(){
        $('.menu .shop').slideToggle(500);
    })
    $('.menu #first-menu4').on('click',function(){
        $('.menu .goods').slideToggle(500);
    })
   
    $('.menu #first-menu5').on('click',function(){
        $('.menu .trader').slideToggle(500);
    })
    $('.menu #first-menu6').on('click',function(){
        $('.menu .promote').slideToggle(500);
    })


    $('.situation .shop-data p').hover(function(){
        $(this).addClass('situation-near-shop-p-add-class');
    },function(){
        $(this).removeClass('situation-near-shop-p-add-class');
    })

})
