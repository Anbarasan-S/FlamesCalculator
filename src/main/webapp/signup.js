const validate=(event)=>{
    event.preventDefault();
    // console.log(event.target.action);
        
    let ajax=new XMLHttpRequest();
    // const form_data=new FormData(event.target);1
    // ajax.open("GET",event.target.action,true);
    // ajax.onload=function()
    // {
    //     console.log(this)
    // }
    // ajax.send('struts.enableJSONValidation=true&struts.validateOnly=false&'+form_data);
    const form_data= $("#form").serialize();
    const options={
        type: 'POST',
        url:event.target.action,
        async:true,
        data: 'struts.enableJSONValidation=true&struts.validateOnly=false&'+form_data,
        processData: false,
        success:function(data,statusText,xhr)
        {
            console.log(data.fieldErrors,statusText,xhr)
        },
        error: function(data){
              console.log(data.ActionError);
         }
        };
        jQuery.ajax(event.target.action,options);
    // ajax.open(event.target.action)
}