let moneyAfterBills = document.getElementById("moneyAfterBills");
let moneyAfterBillsNumber = parseFloat(moneyAfterBills.innerText.substring(1,moneyAfterBills.innerText.length-1));
let spendAmount = document.getElementById("spendAmount");
let amount = (moneyAfterBillsNumber/28);
spendAmount.innerText = "You can spend $" + amount.toFixed(2) + " per day.";
let billTotal = document.getElementById("billTotal");
let billNames = Array.from(document.getElementsByClassName("billName"));
let billAmounts = Array.from(document.getElementsByClassName("billAmount"));
let monthlyIncome = parseFloat(document.getElementById("monthlyIncome").innerText.substring(1,document.getElementById("monthlyIncome").innerText.length-1));



dataArray = [
    ['Monthly Income', 'Expenses'],
    ['Left over after bills', moneyAfterBillsNumber],

]
billNames.forEach((element,index)=>{
    dataArray.push([billNames[index].innerText.charAt(0).toUpperCase() + billNames[index].innerText.slice(1), Number(billAmounts[index].innerText)],)
})

function drawChart() {

    var data = google.visualization.arrayToDataTable(dataArray);

    var options = {
        width: $("#piechartsize").width() - $("#piechartsize").width()*.26,
        height: $("#piechartsize").height(),
        title: 'Budget Broken Down',
        is3D: true
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

    chart.draw(data,options);

    $(window).resize(function(){
        drawChart();
    });

}


google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);
