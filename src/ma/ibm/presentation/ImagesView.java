package ma.ibm.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="imagesview")
public class ImagesView {
     
    private List<String> images;

    @PostConstruct
    public void init() {
    	images = new ArrayList<String>();
    	for(int i=0;i<3;i++) {
    		images.add("excel.png");
    	}
         
    }
 
    public List<String> getImages() {
        return images;
    }
    
}
