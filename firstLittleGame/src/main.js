

//8-   16- 32-   64-            128-         256-                 512-               1024-             -2048                        -4096                                          -8192
var board = new Array();
var score = 0;
var hasConflicted = new Array();

var startx=0;
var starty=0;
var endx=0;
var endy=0;

$(document).ready(function () {
    prepareForMobile();
    newGame();
    
});

function prepareForMobile() {
    if (documentWidth > 500) {
        gridContainerWidth = 500;
        cellSideLength = 110;
        cellSpace = 12;

    }
    $("#grid-container").css('width',gridContainerWidth-2*cellSpace);
    $("#grid-container").css('height',gridContainerWidth-2*cellSpace);
    $("#grid-container").css('padding',cellSpace);
    $("#grid-container").css('border-radius',0.02*gridContainerWidth);

    $(".grid-cell").css('width',cellSideLength);
    $(".grid-cell").css('height',cellSideLength);
    $(".grid-cell").css('border-radius',0.02*cellSideLength);
}

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
        hasConflicted[i] = new Array();
        for( var j = 0 ; j < 4 ; j ++ ){
            board[i][j] = 0;
            hasConflicted[i][j] = false;
        }
    }
    updateBoardView();
    score=0;
    updateScore();
}

function updateBoardView() {
    $(".number-cell").remove();
    var max = board[0][0];
    for( var i = 0 ; i < 4 ; i ++ )
        for( var j = 0 ; j < 4 ; j ++ ){
            $("#grid-container").append( '<div class="number-cell" id="number-cell-'+i+'-'+j+'"></div>' );
            var theNumberCell = $('#number-cell-'+i+'-'+j);

            if( board[i][j] == 0 ){
                theNumberCell.css('width','0px');
                theNumberCell.css('height','0px');
                theNumberCell.css('top',getPosTop(i) + cellSideLength/2);//数字放中间
                theNumberCell.css('left',getPosLeft(j) + cellSideLength/2);
            }
            else{
                theNumberCell.css('width',cellSideLength);
                theNumberCell.css('height',cellSideLength);
                theNumberCell.css('top',getPosTop(i));
                theNumberCell.css('left',getPosLeft(j));
                theNumberCell.css('background-color',getNumberBackgroundColor(board[i][j]));
                theNumberCell.css('color',getNumberColor(board[i][j]));
                theNumberCell.text(board[i][j]);
            }
            if (board[i][j] > max) max = board[i][j];
            //碰撞归位
            hasConflicted[i][j] = false;
        }
    $(".number-cell").css("line-height",cellSideLength+"px");
    $(".number-cell").css("font-size",0.6*cellSideLength+"px");
    //showMyWords(max);
}

function generateOneNumber() {
    if (nospace(board))
        return false;
    //随机一个位置
    var randx = parseInt(Math.floor(Math.random() * 4));//下取整并转化为整型
    var randy = parseInt(Math.floor(Math.random() * 4));

    var times =0;
    while (times<50) {
        if (board[randx][randy] == 0) break;
        else{
            var randx = parseInt(Math.floor(Math.random() * 4));
            var randy = parseInt(Math.floor(Math.random() * 4));
        }
        times++;
    }
    if (times == 50) {
        for( var i = 0 ; i < 4 ; i ++ )
            for( var j = 0 ; j < 4 ; j ++ ){
                if (board[i][j] == 0) {
                    randx = i;
                    randy = j;
                }
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
                event.preventDefault();//阻挡了按键的默认效果
                setTimeout(generateOneNumber(),210);
                setTimeout(isGameOver(),300);
            }
                break;
            case 38:   //up
            if(moveUp()){
                event.preventDefault();//阻挡了按键的默认效果
                setTimeout(generateOneNumber(),210);
                setTimeout(isGameOver(),300);
            }
                break;
            case 39:   //right
            if(moveRight()){
                event.preventDefault();//阻挡了按键的默认效果
                setTimeout(generateOneNumber(),210);
                setTimeout(isGameOver(),300);
            }
                break;
            case 40:   //down
            if(moveDown()){
                event.preventDefault();//阻挡了按键的默认效果
                setTimeout(generateOneNumber(),210);
                setTimeout(isGameOver(),300);
            }
                break;
            default:
                break;
        }
})

document.addEventListener('touchstart',function (event) {
    startx=event.touches[0].pageX;
    starty=event.touches[0].pageY;
});

document.addEventListener('touchend',function (event) {

    endx=event.changedTouches[0].pageX;
    endy=event.changedTouches[0].pageY;
    var deltax=endx-startx;
    var deltay=endy-starty;
    
    //可设置具体阈值来判断是否真的为一次操作
    if( Math.abs( deltax ) < 0.3*documentWidth && Math.abs( deltay ) < 0.3*documentWidth )
        return;
    
    if (Math.abs(deltax)>=Math.abs(deltay)){
        if (deltax > 0) {
            //move right
            if (moveRight()) {
                setTimeout(generateOneNumber(),210);
                setTimeout(isGameOver(),300);
            }
        }
        else{
            //move left
            if (moveLeft()) {
                setTimeout(generateOneNumber(),210);
                setTimeout(isGameOver(),300);
            }
        }
    }
    else{
        if (deltay < 0) {     //???
            //move up
            if (moveUp()) {
                setTimeout(generateOneNumber(),210);
                setTimeout(isGameOver(),300);
            }
        }
        else{
            //move down
            if (moveDown()) {
                setTimeout(generateOneNumber(),210);
                setTimeout(isGameOver(),300);
            }
        }
    }
});


function isGameOver() {
    if (nospace(board)&&(!canMoveDown(board))&&(!canMoveLeft(board))&&(!moveRight(board))&&(!moveUp(board)))
        GameOver();
    else;
}

function GameOver() {
    alert("oh, fail this time !");

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
                    else if (board[i][j] == board[i][k]&&noBlockHorizontal(i,k,j,board)&& (!hasConflicted[i][k])){
                        //move and add
                        showMoveAnimation(i,j,i,k);
                        board[i][k]+=board[i][j];
                        board[i][j]=0;

                        //add score
                        score+=board[i][k];
                        updateScore();

                        hasConflicted[i][k]=true;
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

                    else if (board[i][k] == board[i][j] && noBlockHorizontal(i, j, k, board)&&(!hasConflicted[i][k])) {
                        showMoveAnimation(i,j,i,k);
                        board[i][k]*=2;
                        board[i][j]=0;

                        //add score
                        score+=board[i][k];
                        updateScore();

                        hasConflicted[i][k]=true;

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
                    else if (board[i][j] == board[k][j]&&noBlockVertical(j,k,i,board)&&(!hasConflicted[k][j])){
                        //move and add
                        showMoveAnimation(i,j,k,j);
                        board[k][j]+=board[i][j];
                        board[i][j]=0;

                        //add score
                        score+=board[k][j];
                        updateScore();

                        hasConflicted[k][j]=true;

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
                    else if( board[k][j] == board[i][j] && noBlockVertical( j , i , k , board )&&(!hasConflicted[k][j])){
                        //move
                        showMoveAnimation(i,j,k,j);
                        //add
                        board[k][j] += board[i][j];
                        board[i][j] = 0;

                        //add score
                        score+=board[k][j];
                        updateScore();

                        hasConflicted[k][j]=true;
                        continue;
                    }
                }
            }
        }

    setTimeout("updateBoardView()",200);
    return true;
}
