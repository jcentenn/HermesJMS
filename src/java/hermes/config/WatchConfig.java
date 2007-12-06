//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.12.06 at 11:32:15 GMT 
//


package hermes.config;


/**
 * Java content class for WatchConfig complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/work/Workspaces/Hermes/HermesJMS/src/xml/hermes-schema.xsd line 186)
 * <p>
 * <pre>
 * &lt;complexType name="WatchConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="destination" type="{}DestinationConfig" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="defaultAgeAlertThreshold" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="defaultDepthAlertThreshold" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="showAge" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="updateFrequency" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface WatchConfig {


    /**
     * Gets the value of the updateFrequency property.
     * 
     */
    long getUpdateFrequency();

    /**
     * Sets the value of the updateFrequency property.
     * 
     */
    void setUpdateFrequency(long value);

    /**
     * Gets the value of the defaultAgeAlertThreshold property.
     * 
     */
    long getDefaultAgeAlertThreshold();

    /**
     * Sets the value of the defaultAgeAlertThreshold property.
     * 
     */
    void setDefaultAgeAlertThreshold(long value);

    /**
     * Gets the value of the defaultDepthAlertThreshold property.
     * 
     */
    int getDefaultDepthAlertThreshold();

    /**
     * Sets the value of the defaultDepthAlertThreshold property.
     * 
     */
    void setDefaultDepthAlertThreshold(int value);

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getId();

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setId(java.lang.String value);

    /**
     * Gets the value of the showAge property.
     * 
     */
    boolean isShowAge();

    /**
     * Sets the value of the showAge property.
     * 
     */
    void setShowAge(boolean value);

    /**
     * Gets the value of the Destination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the Destination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDestination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link hermes.config.DestinationConfig}
     * 
     */
    java.util.List getDestination();

}
