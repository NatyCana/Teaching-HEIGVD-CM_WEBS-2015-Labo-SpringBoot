package ch.heigvd.ptl.sc.to;

import ch.heigvd.ptl.sc.model.IssueType;
import ch.heigvd.ptl.sc.model.User;

public class IssueTO {
	private String id;
	
	private String authorId;
	private String typeId;
	private String description;
        private String coords;
        private String actionId;

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
     * @return the authorId
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId the authorId to set
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * @return the typeId
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the typeId to set
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
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

    /**
     * @return the actionId
     */
    public String getActionId() {
        return actionId;
    }

    /**
     * @param actionId the actionId to set
     */
    public void setActionId(String actionId) {
        this.actionId = actionId;
    }


        

}
