
var borad = new Array();
var score = 0;

$(document).ready(function () {
    newGame();
    
});

function newGame() {
    //初始化操作
    init();
}

function init() {
    for (var i = 0; i < 4; i++) {
        for (var j = 0; j < 4; j++) {
            var gridCell = $("#grid-cell-" + i + "-" + j);
            gridCell.css({'top':getPosTop(i),'left':getPosLeft(j)});
        }
    }
}