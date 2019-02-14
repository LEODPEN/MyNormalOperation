
documentWidth = window.screen.availWidth;
gridContainerWidth = 0.92*documentWidth;
cellSideLength = 0.18*documentWidth;
cellSpace = 0.04*documentWidth;

function getPosTop(i) {
    return cellSpace + i*(cellSpace+cellSideLength);
}

function getPosLeft(j) {
    return cellSpace + j*(cellSpace+cellSideLength);
}

function getNumberBackgroundColor(number){
    switch(number){
        case 2:return "#eee4da";
        case 4:return "#ede0c8";
        case 8:return "#f2b179";
        case 16:return "#f59563";
        case 32:return "#f67c5f";
        case 64:return "#f65e3b";
        case 128:return "#edcf72";
        case 256:return "#edcc61";
        case 512:return "#9c0";
        case 1024:return "#33b5e5";
        case 2048:return "#09c";
        case 4096:return "#a6c";
        case 8192:return "#93c";
    }
    return "black";
}

/*function showMyWords(max) {
    var words ="";
    switch (max) {
        case 8: words+=myWords[0];break;
        case 16: for (var i = 0; i < 2; i++) words+=myWords[i];break;
        case 32: for (var i = 0; i < 3; i++) words+=myWords[i];break;
        case 64: for (var i = 0; i < 4; i++) words+=myWords[i];break;
        case 128: for (var i = 0; i < 5; i++) words+=myWords[i];break;
        case 256: for (var i = 0; i < 6; i++) words+=myWords[i];break;
        case 512: for (var i = 0; i < 7; i++) words+=myWords[i];break;
        case 1024: for (var i = 0; i < 8; i++) words+=myWords[i];break;
        case 2048: for (var i = 0; i < 9; i++) words+=myWords[i];break;
        case 4096: for (var i = 0; i < 10; i++) words+=myWords[i];break;
        case 8192: for (var i = 0; i < 11; i++) {words+=myWords[i];/*if (i === 7) words+="\n";*//*}break;
        default: words=words;
    }
    updateMyWords(words);
}*/


function getNumberColor(number){
    if( number <= 4 )
        return "#776e65";

    return "white";
}

function nospace(board) {
    for (var i = 0; i < 4; i++) {
        for (var j = 0; j < 4; j++) {
            if (board[i][j] == 0) return false;
        }
    }
    return true;
}

function canMoveLeft(board) {
    for (var i = 0; i < 4; i++) {
        for (var j = 1; j < 4; j++) {
            if (board[i][j] != 0) {
                if (board[i][j - 1] == 0 || board[i][j - 1] == board[i][j]) return true;
            }
        }
    }
    return false;
}

function canMoveRight(board) {
    for (var i = 0; i < 4; i++) {
        for (var j = 2; j >= 0; j--) {
            if (board[i][j] != 0) {
                if (board[i][j + 1] == 0 || board[i][j + 1] == board[i][j]) return true;
            }
        }
    }
    return false;
}

function canMoveUp(board) {
    for (var j = 0; j < 4; j++) {
        for (var i = 1; i < 4; i++) {
            if (board[i][j] != 0) {
                if (board[i - 1][j] == 0 || board[i - 1][j] == board[i][j]) return true;
            }
        }
    }
}

function canMoveDown(board) {
    for (var j = 0; j < 4; j++) {
        for (var i = 2; i >= 0; i--) {
            if (board[i][j] != 0) {
                if (board[i + 1][j] == 0 || board[i + 1][j] == board[i][j]) return true;
            }
        }
    }
}

function noBlockVertical(col, row1, row2, board) {
    for (var i = row1 + 1; i < row2; i++) {
        if (board[i][col] != 0)
            return false;
    }
    return true;
}

function noBlockHorizontal(row, col1, col2, board) {
    for (var i = col1 + 1; i < col2; i++) {
        if (board[row][i] != 0)
            return false;
    }
    return true;
}

