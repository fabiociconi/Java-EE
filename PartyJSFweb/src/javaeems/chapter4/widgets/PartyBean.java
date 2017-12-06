package javaeems.chapter4.widgets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("partyBean")
@SessionScoped
public class PartyBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
    private boolean parentsAllowed;
    private List<Guest>items;
    private String imageUri;
    
    public PartyBean() {
        this.reset();
    }
    
    public String getImageUri() {
        return this.imageUri;
    }
    
    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    } 
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean getParentsAllowed() {
        return parentsAllowed;
    }
    
    public void setParentsAllowed(boolean on) {
        this.parentsAllowed = on;
    }
    
    public List<Guest> getItems() {
        return this.items;
    }
    
    public void reset() {
        this.name = "(party title)";
        this.parentsAllowed = false;
        this.items = new ArrayList<>();
        items.add(new Guest("Sally", 6));
        items.add(new Guest("Carlos", 7));
        items.add(new Guest("Nathan", 6));
        this.imageUri = "party1.jpg";
    }
    
    
    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("My party is called " + this.name);
        sb.append(", ");
        sb.append(" there are " + items.size() + " guests");
        sb.append(", ");
        sb.append("and parents are " + (parentsAllowed ? "": "not") + " allowed to stay.");
        return sb.toString();
        
    }
    
}
