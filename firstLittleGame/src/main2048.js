
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

$(document).keydown(function (event) {
    switch (event.keyCode)
        {
            case 37:   //left
            if(moveLeft()){
                generateOneNumber();
                isGameOver();
            }
                break;
            case 38:   //up
            if(moveUp()){
                generateOneNumber();
                isGameOver();
            }
                break;
            case 39:   //right
            if(moveRight()){
                generateOneNumber(); //找到飘动数字罪魁祸首！
                isGameOver();
            }
                break;
            case 40:   //down
            if(moveDown()){
                generateOneNumber();
                isGameOver();
            }
                break;
            default:
                break;
        }
})

function isGameOver() {

}

function moveLeft() {
    
    if (!canMoveLeft(board)) return false;

    for (var i = 0; i < 4; i++) {
        for (var j = 1; j < 4; j++) {
            if (board[i][j] != 0) {
                for (var k = 0; k < j; k++) {
                    if (board[i][k] == 0 && noBlockHorizontal(i, k, j, board)) {
                        //move
                        showMoveAnimation(i,j,i,k);
                        board[i][k]=board[i][j];
                        board[i][j]=0;


                        continue;//移到不能移到为止
                    }
                    else if (board[i][j] == board[i][k]&&noBlockHorizontal(i,k,j,board)){
                        //move and add
                        showMoveAnimation(i,j,i,k);
                        board[i][k]+=board[i][j];
                        board[i][j]=0;


                        continue;
                    }
                }
            }
        }
    }
    setTimeout("updateBoardView()",200);//保证动画效果完整展示出来
    return true;
}

function moveRight() {
    if (!canMoveRight(board))
        return false;
    //move
    for (var i = 0; i < 4; i++) {
        for (var j = 2; j >= 0; j--) {
            if (board[i][j] != 0) {         //这句话不加真的害人啊!!!
                for (var k = 3 ; k > j; k--) {
                    if (board[i][k] == 0 && noBlockHorizontal(i, j, k, board)){
                        showMoveAnimation(i,j,i,k);
                        board[i][k]=board[i][j];
                        board[i][j]=0;

                        continue;  // 依旧一直移动
                    }

                    else if (board[i][k] == board[i][j] && noBlockHorizontal(i, j, k, board)) {
                        showMoveAnimation(i,j,i,k);
                        board[i][k]*=2;
                        board[i][j]=0;

                        continue;
                    }
                }
            }
        }
    }
    setTimeout("updateBoardView()",200);
    return true;
}


function moveUp() {

    if (!canMoveUp(board)) return false;

    for (var j = 0; j < 4; j++) {
        for (var i = 1; i < 4; i++) {
            if (board[i][j] != 0) {
                for (var k = 0; k < i; k++) {
                    if (board[k][j] == 0 && noBlockVertical(j, k, i, board)) {
                        //move
                        showMoveAnimation(i,j,k,j);
                        board[k][j]=board[i][j];
                        board[i][j]=0;


                        continue;//移到不能移到为止
                    }
                    else if (board[i][j] == board[k][j]&&noBlockVertical(j,k,i,board)){
                        //move and add
                        showMoveAnimation(i,j,k,j);
                        board[k][j]+=board[i][j];
                        board[i][j]=0;


                        continue;
                    }
                }
            }
        }
    }
    setTimeout("updateBoardView()",200);//保证动画效果完整展示出来
    return true;
}

function moveDown(){
    if( !canMoveDown(board) )
        return false;

    //moveDown
    for( var j = 0 ; j < 4 ; j ++ )
        for( var i = 2 ; i >= 0 ; i -- ){
            if( board[i][j] != 0 ){
                for( var k = 3 ; k > i ; k -- ){

                    if( board[k][j] == 0 && noBlockVertical(j,i,k,board)){
                        //move
                        showMoveAnimation(i,j,k,j);
                        board[k][j] = board[i][j];
                        board[i][j] = 0;

                        continue;
                    }
                    else if( board[k][j] == board[i][j] && noBlockVertical( j , i , k , board )){
                        //move
                        showMoveAnimation(i,j,k,j);
                        //add
                        board[k][j] += board[i][j];
                        board[i][j] = 0;

                        continue;
                    }
                }
            }
        }

    setTimeout("updateBoardView()",200);
    return true;
}
