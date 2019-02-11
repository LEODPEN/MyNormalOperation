
var board = new Array();
var score = 0;

$(document).ready(function () {
    newGame();
    
});

function newGame() {
    //初始化操作
    init();
    //随机两个格子生成数字
    generateOneNumber();
    generateOneNumber();

}

function init() {
    for (var i = 0; i < 4; i++) {
        for (var j = 0; j < 4; j++) {
            var gridCell = $("#grid-cell-" + i + "-" + j);
            gridCell.css({'top':getPosTop(i),'left':getPosLeft(j)});
        }
    }
    for( var i = 0 ; i < 4 ; i ++ ){
        board[i] = new Array();
        for( var j = 0 ; j < 4 ; j ++ ){
            board[i][j] = 0;

        }
    }
    updateBoardView();
}

function updateBoardView() {
    $(".number-cell").remove();
    for( var i = 0 ; i < 4 ; i ++ )
        for( var j = 0 ; j < 4 ; j ++ ){
            $("#grid-container").append( '<div class="number-cell" id="number-cell-'+i+'-'+j+'"></div>' );
            var theNumberCell = $('#number-cell-'+i+'-'+j);

            if( board[i][j] == 0 ){
                theNumberCell.css('width','0px');
                theNumberCell.css('height','0px');
                theNumberCell.css('top',getPosTop(i) + 55);//数字放中间
                theNumberCell.css('left',getPosLeft(j) + 55);
            }
            else{
                theNumberCell.css('width','110px');
                theNumberCell.css('height','110px');
                theNumberCell.css('top',getPosTop(i));
                theNumberCell.css('left',getPosLeft(j));
                theNumberCell.css('background-color',getNumberBackgroundColor(board[i][j]));
                theNumberCell.css('color',getNumberColor(board[i][j]));
                theNumberCell.text(board[i][j]);
            }
            //hasConflicted[i][j] = false;
        }
}

function generateOneNumber() {
    if (nospace(board))
        return false;
    //随机一个位置
    var randx = parseInt(Math.floor(Math.random() * 4));//下取整并转化为整型
    var randy = parseInt(Math.floor(Math.random() * 4));
    while (true) {
        if (board[randx][randy] == 0) break;
        else{
            var randx = parseInt(Math.floor(Math.random() * 4));
            var randy = parseInt(Math.floor(Math.random() * 4));
        }
    }
    //随机一个数字
    var randomNumber = Math.random()<0.5? 2:4;

    //随机位置上显示出来
    board[randx][randy]=randomNumber;
    showNumberWithAnimation(randx,randy,randomNumber);

    return true;
}