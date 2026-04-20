package lost_found_items;

import java.util.Comparator;
import java.io.Serializable;
public class Describe_Item_Comparator implements Comparator<Describe_Item_Comparator>,Serializable
{
	int itemid;
	String itemname;
	String category;
	String foundat;
	int price;
	String status;
	String report_time;
	
	public Describe_Item_Comparator()
	{
		
	}
	public Describe_Item_Comparator(int itemid,String itemname,String category,String foundat,int price,String status,String report_time)
	{
		 this.itemid=itemid;
		 this.itemname=itemname;
		 this.category=category;
		 this.foundat=foundat;
		 this.price=price;
		 this.status=status;
		 this.report_time=report_time;
	}
	
	public int compare(Describe_Item_Comparator i1,Describe_Item_Comparator i2)
	{
		return i2.report_time.compareTo(i1.report_time);  //i1 followed by i2 because we want in descending order
		
	}
}
