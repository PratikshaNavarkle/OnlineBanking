function confirmTransfer()
{
	var r=confirm("Press Yes To Confirm The Transaction :");
	if(r==true)
	{
		alert("Transaction Proceded..Wait Till Transaction Completes");
		var f=document.regis;
		f.action="http://localhost:8007/InternetBanking/TransferServlet";
		f.submit();
	}
	else
	{
		alert("Transaction Dropped By User...");
	}
}
function validate()
{
	alert("validate");
	var d=new Date();
	var a=d.getDay();
	var h=d.getHours();
	var x,y;
	with(window.document.forms.regis)
	{	
		f=0
		var bt = document.getElementById('Transfer');
        bt.disabled = true;
		if (type.value=="neft")
		{
			if(a==0)
			{
				alert("Today Is Sunday(Bank Holiday)...Transfer Cannot Be Processed")
			}
			else if(a==6)
			{
				if(h<8 || h>13)
				{
					alert("NEFT NOT AVAILABLE AT CURRENT TIME (VALID TIME FOR TRANSACTION ON SATURDAY : 8 AM - 1 PM )")
				}
			}
			else if(h<8 || h>18)
			{
				alert("NEFT NOT AVAILABLE AT CURRENT TIME (VALID TIME FOR TRANSACTION ON WEEKDAYS : 8 AM - 6 PM )")
			}
			else if(amount.value>50000)
			{
					f=1
					alert("Entered Amount Is Not Valid For NEFT Transfer.Amount Should Be Less Than 50,000...!!!!")
			}
			else{
				bt.disabled = false;
			}
		}
		else if (type.value=="rtgs")
		{
			if(a==0)
			{
				alert("Today Is Sunday(Bank Holiday)...Transfer Cannot Be Processed")
			}
			else if(a==6)
			{
				if(h<7 || h>13)
				{
					alert("RTGS NOT AVAILABLE AT CURRENT TIME (VALID TIME FOR TRANSACTION ON SATURDAY : 7 AM - 1 PM )")
				}
			}
			else if(h<7 || h>18)
			{
				alert("RTGS NOT AVAILABLE AT CURRENT TIME (VALID TIME FOR TRANSACTION ON WEEKDAYS : 7 AM - 6 PM )")
			}
			else if(amount.value<200000)
			{
					f=1
					alert("Entered Amount Is Not Valid For RTGS Transfer.Amount Should Be Greater Than 2,00,000...!!!!")
			}
			else{
				bt.disabled = false;
			}
		}
		else if (type.value=="imps")
		{
			if(amount.value>200000)
			{
					f=1
					alert("Entered Amount Is Not Valid For IMPS Transfer.Amount Should Be Less Than 2,00,000...!!!!")
			}
			else{
				bt.disabled = false;
			}
		}
		else
		{
			alert("Transaction type not selected ....!!!");
		}
	}
}