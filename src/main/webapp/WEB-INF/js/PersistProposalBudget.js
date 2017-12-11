/**
 * Created by iNaS2 on 12/1/2017.
 */
var fundsList = [];
var descsList = [];

function buildFunds(way){
    fundsList = [];
    descsList = [];
    let x = ['1','Ben','2','3','4'];
    let y = ['a','b','c'];

    if(way == 'GET') { // get the elements
        x.forEach((xEle)=>{
            y.forEach((yEle)=>{
                fundsList.push($('#source1_'+ yEle +'_'+xEle.toLowerCase()));
                fundsList.push($('#source2_'+ yEle +'_'+xEle.toLowerCase()));
                fundsList.push($('#source3_'+ yEle+'_'+xEle.toLowerCase()));
                fundsList.push($('#requested_'+ yEle+'_'+xEle.toLowerCase()));
                descsList.push($('#'+yEle+xEle));

            })
        })
            console.log("inside GET");
    } else{ // only get the elements values
        x.forEach((xEle) => {
            y.forEach((yEle) => {
                fundsList.push($('#source1_' + yEle + '_' + xEle.toLowerCase()).val());
                fundsList.push($('#source2_' + yEle + '_' + xEle.toLowerCase()).val());
                fundsList.push($('#source3_' + yEle + '_' + xEle.toLowerCase()).val());
                fundsList.push($('#requested_' + yEle + '_' + xEle.toLowerCase()).val());
                descsList.push($('#' + yEle + xEle).val());
            })
        })
    }
}

function updateProposalBudget() {
    buildFunds();
    $(function () {
        $.ajax({
            type: "POST",
            url: '/eRSPG/proposalBudgetData',
            datatype: 'json',
            data: {
                fundsList :  fundsList,
                descsList : descsList
            },
            cache: false,
            success: (data) => {
                console.log("updated Budget Funds")
            }
        })
        return false;
    });
}

function getProposalBudget() {
    $(function () {
        $.ajax({
            type: "GET",
            url: '/eRSPG/getProposalBudgetData',
            datatype: 'json',
            data: {

            },
            cache: false,
            success: (data) => {
                buildFunds('GET');

                $(()=>{for(i=0;i<data.length;i++){
                    fundsList[i].val(data[i].fundAmount);
                    descsList[parseInt(i/4)][0].value = (data[i].description);
                }})

                console.log("Loaded Budget Funds")
            }
        })
        return false;
    });
}


//highly recommend using this timer for saving, then adding the update event to the onclick for
// the "next" button in addition to what it already has. It will decrease pressure on the the DB
//TODO:Ask the team to vote on this
var timeout = null;
function updateAfterDelay() {
    clearTimeout(timeout);

    timeout = setTimeout(function () {
        runFilter();
    }, 3000);
}


$(function () {
    $('input:text[readonly!="readonly"]').on("blur",updateProposalBudget);
    $(document).ready(getProposalBudget());
});