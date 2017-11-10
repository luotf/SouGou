$(function(){
    var myChart = echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '商品信息表',
            subtext:'',
        },
        toolbox:{
            show:true,
            feature:{
                dataview:{
                    show:true
                },
                restore:{
                    show:true
                },
                dataZoom:{
                    show:true
                },
                saveAsImage:{
                    show:true
                },
                magicType:{
                    type:['line','bar']
                }
            }
        },
        tooltip: {
            show:true
        },
        legend: {
            data:['数量']
        },
        xAxis: {
            data: ["普通商品","上新商品","秒杀商品","折扣商品"]
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'line',
            data: [10, 5, 3, 6],
            markPoint:{
                data:[
                    {type:'max',name:'最大值'},
                    {type:'min',name:'最小值'}
                ]
            },/*标记最大值和最小值*/
            markLine:{
                data:[
                    {type:'average',name:'平均值'}
                ]
            }
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    var myChart2 = echarts.init(document.getElementById('main2'));
    // 指定图表的配置项和数据
    var option2 = {
        title: {
            text: '上下架商品信息',
            subtext:'',
        },
        toolbox:{
            show:true,
            feature:{
                dataview:{
                    show:true
                },
                restore:{
                    show:true
                },
                dataZoom:{
                    show:true
                },
                saveAsImage:{
                    show:true
                },
                magicType:{
                    type:['line','bar']
                }
            }
        },
        tooltip: {
            show:true
        },
        legend: {
            data:['数量']
        },
        xAxis: {
            data: ["上架商品","下架商品"]
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'bar',
            data: [23, 5],
            markPoint:{
                data:[
                    {type:'max',name:'最大值'},
                    {type:'min',name:'最小值'}
                ]
            },/*标记最大值和最小值*/
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart2.setOption(option2);
})