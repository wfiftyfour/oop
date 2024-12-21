package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		float x;
		x=o1.cost-o2.cost;
		if(x==0)
			 return o1.title.compareTo(o2.title);
		else
			return (int)x;
		
	}
	

}
