package ch.heigvd.ptl.sc.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Issue {
	@Id
	private String id;
	
	private User author;
	private IssueType type;
	private String description;
        private String coords;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the author
     */
    public User getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * @return the type
     */
    public IssueType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(IssueType type) {
        this.type = type;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the coords
     */
    public String getCoords() {
        return coords;
    }

    /**
     * @param coords the coords to set
     */
    public void setCoords(String coords) {
        this.coords = coords;
    }
        

}
