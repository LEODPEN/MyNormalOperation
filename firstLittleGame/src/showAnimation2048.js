
function showNumberWithAnimation(randx, randy, randomNumber) {
    var numberCell = $("#number-cell-"+randx+"-"+randy);
    numberCell.css("background-color",getNumberBackgroundColor(randomNumber));
    numberCell.css("color",getNumberColor(randomNumber));


    //动画函数，在50毫秒完成动画
    numberCell.animate({
        width:"110px",
        height:"110px",
        top:getPosTop(randx),
        left:getPosLeft(randy)

    },50);
    numberCell.text(randomNumber);
}

function showMoveAnimation(fromx, fromy, tox, toy) {
    var numberCell = $("#number-cell-"+fromx+"-"+fromy);
    numberCell.animate({
        top:getPosTop(tox),
        left:getPosLeft(toy)
    },200);
}