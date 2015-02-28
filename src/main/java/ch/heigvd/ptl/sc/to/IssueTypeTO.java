/*
 * Developped at Heig-VD.ch during the WebService lecture
 * Authors: Natalie Canonica, Maya Jeanmonod
 * Date: 18-feb-2015
 */
package ch.heigvd.ptl.sc.to;


public class IssueTypeTO {

    private String id;
    private String shortName;
    private String description;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
