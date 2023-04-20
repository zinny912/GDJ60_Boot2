//page를 요청할 수 있도록 만든 이벤트
$('#machineListResult').on("click",".page-qna",function(e){
    let page = $(this).attr('data-board-page');
    let kind =''
    $(".searchOption").each(function(idx, item){
        if($(item).prop("selected")){
            kind = $(item).val();
        }
    })

    let search = $("#search").val();

    fetch("/machineQna/list?machineNum="+machineQnaList.getAttribute('data-qna-machineNum')+"&page="+page+"&kind="+kind+"&search="+search,{
        method:'GET'
    })
    .then((response)=>response.text())
    .then((res)=>{
        $('#machineListResult').html(res.trim());
    })

    e.preventDefault();
})
