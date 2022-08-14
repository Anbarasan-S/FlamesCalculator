/**
 * 
 */

 if (document.cookie) {
    const values = document.cookie.split(";");
    for (let value of values) {
        let name = value.split("=");

        if (name[0].trim() === "name") {
            if (name[1])
                document.getElementById("name").value = name[1];
        }
    }
}

 const calculateHandler=(event)=>
 {
     event.preventDefault();
    const name=document.getElementsByName('name')[0];
    const crush_name=document.getElementsByName('crush_name')[0];
    if(name.value==null)
    {
        name.style.borderColor="red";
        return;
    }
    if(crush_name.value==="")
    {
        crush_name.focus();
        return;
    }

    event.target.submit();
 }


 
 const showFlamesForm=(event)=>
 {
        document.getElementsByClassName("love-tips")[0].style.display="none";
        document.getElementsByClassName("response-btn")[0].style.setProperty('display','none','important');
        document.getElementsByClassName("flames-form")[0].style.setProperty('display','inline-block','important');
        document.getElementById("close").style.display="";
 }

 const button = document.getElementById('close');

button.addEventListener('click', (event) => {
  close(event);
});


 const close=(event)=>
 {
    console.log('d');
    document.getElementById("close").style.display="none";
    document.getElementsByClassName("love-tips")[0].style.display="";
    document.getElementsByClassName("response-btn")[0].style.display='';
    document.getElementsByClassName("flames-form")[0].style.display="none";
 }