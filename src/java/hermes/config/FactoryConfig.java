//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.06.06 at 08:20:15 AM BST 
//


package hermes.config;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FactoryConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FactoryConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="provider" type="{}ProviderConfig"/>
 *         &lt;element name="connection" type="{}ConnectionConfig" maxOccurs="unbounded"/>
 *         &lt;element name="destination" type="{}DestinationConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="extension" type="{}ProviderExtConfig" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="classpathId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FactoryConfig", propOrder = {
    "provider",
    "connection",
    "destination",
    "extension"
})
public class FactoryConfig {

    @XmlElement(required = true)
    protected ProviderConfig provider;
    @XmlElement(required = true)
    protected List<ConnectionConfig> connection;
    protected List<DestinationConfig> destination;
    protected ProviderExtConfig extension;
    @XmlAttribute(name = "classpathId")
    protected String classpathId;

    /**
     * Gets the value of the provider property.
     * 
     * @return
     *     possible object is
     *     {@link ProviderConfig }
     *     
     */
    public ProviderConfig getProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderConfig }
     *     
     */
    public void setProvider(ProviderConfig value) {
        this.provider = value;
    }

    /**
     * Gets the value of the connection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConnection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConnectionConfig }
     * 
     * 
     */
    public List<ConnectionConfig> getConnection() {
        if (connection == null) {
            connection = new ArrayList<ConnectionConfig>();
        }
        return this.connection;
    }

    /**
     * Gets the value of the destination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the destination property.
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
     * {@link DestinationConfig }
     * 
     * 
     */
    public List<DestinationConfig> getDestination() {
        if (destination == null) {
            destination = new ArrayList<DestinationConfig>();
        }
        return this.destination;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link ProviderExtConfig }
     *     
     */
    public ProviderExtConfig getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderExtConfig }
     *     
     */
    public void setExtension(ProviderExtConfig value) {
        this.extension = value;
    }

    /**
     * Gets the value of the classpathId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClasspathId() {
        return classpathId;
    }

    /**
     * Sets the value of the classpathId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClasspathId(String value) {
        this.classpathId = value;
    }

}
