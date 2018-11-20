let moneyAfterBills = document.getElementById("moneyAfterBills");
let moneyAfterBillsNumber = parseFloat(moneyAfterBills.innerText.substring(1,moneyAfterBills.innerText.length-1));
let spendAmount = document.getElementById("spendAmount");
let amount = (moneyAfterBillsNumber/28);
spendAmount.innerText = "You can spend $" + amount.toFixed(2) + " per day.";
let billTotal = document.getElementById("billTotal");

google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

    var data = google.visualization.arrayToDataTable([
        ['Monthly Income', 'Expenses'],
        ['Total of bills', Number(billTotal.innerText.substring(1,billTotal.innerText.length-1))],
        ['Daily Spending', moneyAfterBillsNumber]
    ]);

    var options = {
        title: 'Monthly Income Broken Down'
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

    chart.draw(data, options);
}