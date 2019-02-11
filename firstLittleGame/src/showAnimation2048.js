
function showNumberWithAnimation(randx, randy, randomNumber) {
    var numberCell = $("#number-cell-"+randx+"-"+randy);
    numberCell.css("background-color",getNumberBackgroundColor(randomNumber));
    numberCell.css("color",getNumberColor(randomNumber));
    numberCell.text(randomNumber);

    //动画函数，在50毫秒完成动画
    numberCell.animate({
        width:"110px",
        height:"110px",
        top:getPosTop(randx),
        left:getPosLeft(randy)

    },50);
}