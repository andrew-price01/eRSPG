/**
 * Created by iNaS2 on 12/1/2017.
 */
source1 = [];
source2 = [];
source3 = [];

function updateProposalBudget() {
    $(function () {
        $.ajax({
            type: "POST",
            url: '/eRSPG/proposalBudgetData',
            data: {
            },
            datatype: 'json',
            cache: false,
            success: (data) => {
                console.log("succ")
            }
        })
        return false;
    });
}

$(function () {
//bind event listeners
});

$(function(){
//build arrays
});