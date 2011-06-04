//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-646 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.06.04 at 09:54:53 AM BST 
//


package hermes.config;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HermesConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HermesConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classpathGroup" type="{}ClasspathGroupConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="watch" type="{}WatchConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="naming" type="{}NamingConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="renderer" type="{}RendererConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="loader" type="{}ClasspathConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="factory" type="{}FactoryConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="remote" type="{}RemoteConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="jdbcStore" type="{}JDBCStore" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="filters" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="quickFIX" type="{}QuickFIXConfig" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="lastEditedByUser" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lastEditedByHermesVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="maxThreadPoolSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="auditDirectory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="messageFilesDir" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="maxMessagesInBrowserPane" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="copyJMSProviderProperties" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="copyJMSCorrelationID" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="copyJMSType" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="copyJMSExpiration" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="copyJMSReplyTo" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="copyJMSPriority" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="embeddedMessageInBrowsePane" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="displayFactoryAdmin" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="maxColumnsInStatisticsTable" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="autoBrowseRefreshRate" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="correctDropSemantics" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="selectorImpl" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="queueBrowseConsumerTimeout" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="enableJython" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="lookAndFeel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="messageStoreSession" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="scrollMessagesDuringBrowse" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="deliveryModePersistent" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="base64EncodeMessages" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="messageStoreMessageFactory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="showDestinationsInMessageStore" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HermesConfig", propOrder = {
    "classpathGroup",
    "watch",
    "naming",
    "renderer",
    "loader",
    "factory",
    "remote",
    "jdbcStore",
    "filters",
    "quickFIX"
})
public class HermesConfig {

    protected List<ClasspathGroupConfig> classpathGroup;
    protected List<WatchConfig> watch;
    protected List<NamingConfig> naming;
    protected List<RendererConfig> renderer;
    protected List<ClasspathConfig> loader;
    protected List<FactoryConfig> factory;
    protected List<RemoteConfig> remote;
    protected List<JDBCStore> jdbcStore;
    protected List<String> filters;
    protected QuickFIXConfig quickFIX;
    @XmlAttribute
    protected Integer version;
    @XmlAttribute
    protected String lastEditedByUser;
    @XmlAttribute
    protected String lastEditedByHermesVersion;
    @XmlAttribute
    protected String displayName;
    @XmlAttribute
    protected Integer maxThreadPoolSize;
    @XmlAttribute
    protected String auditDirectory;
    @XmlAttribute
    protected String messageFilesDir;
    @XmlAttribute
    protected Integer maxMessagesInBrowserPane;
    @XmlAttribute
    protected Boolean copyJMSProviderProperties;
    @XmlAttribute
    protected Boolean copyJMSCorrelationID;
    @XmlAttribute
    protected Boolean copyJMSType;
    @XmlAttribute
    protected Boolean copyJMSExpiration;
    @XmlAttribute
    protected Boolean copyJMSReplyTo;
    @XmlAttribute
    protected Boolean copyJMSPriority;
    @XmlAttribute
    protected Boolean embeddedMessageInBrowsePane;
    @XmlAttribute
    protected Boolean displayFactoryAdmin;
    @XmlAttribute
    protected Integer maxColumnsInStatisticsTable;
    @XmlAttribute
    protected Integer autoBrowseRefreshRate;
    @XmlAttribute
    protected Boolean correctDropSemantics;
    @XmlAttribute
    protected String selectorImpl;
    @XmlAttribute
    protected Long queueBrowseConsumerTimeout;
    @XmlAttribute
    protected Boolean enableJython;
    @XmlAttribute
    protected String lookAndFeel;
    @XmlAttribute
    protected String messageStoreSession;
    @XmlAttribute
    protected Boolean scrollMessagesDuringBrowse;
    @XmlAttribute
    protected Boolean deliveryModePersistent;
    @XmlAttribute
    protected Boolean base64EncodeMessages;
    @XmlAttribute
    protected String messageStoreMessageFactory;
    @XmlAttribute
    protected Boolean showDestinationsInMessageStore;

    /**
     * Gets the value of the classpathGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classpathGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClasspathGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClasspathGroupConfig }
     * 
     * 
     */
    public List<ClasspathGroupConfig> getClasspathGroup() {
        if (classpathGroup == null) {
            classpathGroup = new ArrayList<ClasspathGroupConfig>();
        }
        return this.classpathGroup;
    }

    /**
     * Gets the value of the watch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the watch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WatchConfig }
     * 
     * 
     */
    public List<WatchConfig> getWatch() {
        if (watch == null) {
            watch = new ArrayList<WatchConfig>();
        }
        return this.watch;
    }

    /**
     * Gets the value of the naming property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the naming property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNaming().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NamingConfig }
     * 
     * 
     */
    public List<NamingConfig> getNaming() {
        if (naming == null) {
            naming = new ArrayList<NamingConfig>();
        }
        return this.naming;
    }

    /**
     * Gets the value of the renderer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the renderer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRenderer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RendererConfig }
     * 
     * 
     */
    public List<RendererConfig> getRenderer() {
        if (renderer == null) {
            renderer = new ArrayList<RendererConfig>();
        }
        return this.renderer;
    }

    /**
     * Gets the value of the loader property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loader property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoader().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClasspathConfig }
     * 
     * 
     */
    public List<ClasspathConfig> getLoader() {
        if (loader == null) {
            loader = new ArrayList<ClasspathConfig>();
        }
        return this.loader;
    }

    /**
     * Gets the value of the factory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the factory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFactory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FactoryConfig }
     * 
     * 
     */
    public List<FactoryConfig> getFactory() {
        if (factory == null) {
            factory = new ArrayList<FactoryConfig>();
        }
        return this.factory;
    }

    /**
     * Gets the value of the remote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RemoteConfig }
     * 
     * 
     */
    public List<RemoteConfig> getRemote() {
        if (remote == null) {
            remote = new ArrayList<RemoteConfig>();
        }
        return this.remote;
    }

    /**
     * Gets the value of the jdbcStore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jdbcStore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJdbcStore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JDBCStore }
     * 
     * 
     */
    public List<JDBCStore> getJdbcStore() {
        if (jdbcStore == null) {
            jdbcStore = new ArrayList<JDBCStore>();
        }
        return this.jdbcStore;
    }

    /**
     * Gets the value of the filters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFilters() {
        if (filters == null) {
            filters = new ArrayList<String>();
        }
        return this.filters;
    }

    /**
     * Gets the value of the quickFIX property.
     * 
     * @return
     *     possible object is
     *     {@link QuickFIXConfig }
     *     
     */
    public QuickFIXConfig getQuickFIX() {
        return quickFIX;
    }

    /**
     * Sets the value of the quickFIX property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuickFIXConfig }
     *     
     */
    public void setQuickFIX(QuickFIXConfig value) {
        this.quickFIX = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVersion(Integer value) {
        this.version = value;
    }

    /**
     * Gets the value of the lastEditedByUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastEditedByUser() {
        return lastEditedByUser;
    }

    /**
     * Sets the value of the lastEditedByUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastEditedByUser(String value) {
        this.lastEditedByUser = value;
    }

    /**
     * Gets the value of the lastEditedByHermesVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastEditedByHermesVersion() {
        return lastEditedByHermesVersion;
    }

    /**
     * Sets the value of the lastEditedByHermesVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastEditedByHermesVersion(String value) {
        this.lastEditedByHermesVersion = value;
    }

    /**
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Gets the value of the maxThreadPoolSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxThreadPoolSize() {
        return maxThreadPoolSize;
    }

    /**
     * Sets the value of the maxThreadPoolSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxThreadPoolSize(Integer value) {
        this.maxThreadPoolSize = value;
    }

    /**
     * Gets the value of the auditDirectory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditDirectory() {
        return auditDirectory;
    }

    /**
     * Sets the value of the auditDirectory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditDirectory(String value) {
        this.auditDirectory = value;
    }

    /**
     * Gets the value of the messageFilesDir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageFilesDir() {
        return messageFilesDir;
    }

    /**
     * Sets the value of the messageFilesDir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageFilesDir(String value) {
        this.messageFilesDir = value;
    }

    /**
     * Gets the value of the maxMessagesInBrowserPane property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxMessagesInBrowserPane() {
        return maxMessagesInBrowserPane;
    }

    /**
     * Sets the value of the maxMessagesInBrowserPane property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxMessagesInBrowserPane(Integer value) {
        this.maxMessagesInBrowserPane = value;
    }

    /**
     * Gets the value of the copyJMSProviderProperties property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCopyJMSProviderProperties() {
        if (copyJMSProviderProperties == null) {
            return true;
        } else {
            return copyJMSProviderProperties;
        }
    }

    /**
     * Sets the value of the copyJMSProviderProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCopyJMSProviderProperties(Boolean value) {
        this.copyJMSProviderProperties = value;
    }

    /**
     * Gets the value of the copyJMSCorrelationID property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCopyJMSCorrelationID() {
        if (copyJMSCorrelationID == null) {
            return true;
        } else {
            return copyJMSCorrelationID;
        }
    }

    /**
     * Sets the value of the copyJMSCorrelationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCopyJMSCorrelationID(Boolean value) {
        this.copyJMSCorrelationID = value;
    }

    /**
     * Gets the value of the copyJMSType property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCopyJMSType() {
        if (copyJMSType == null) {
            return true;
        } else {
            return copyJMSType;
        }
    }

    /**
     * Sets the value of the copyJMSType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCopyJMSType(Boolean value) {
        this.copyJMSType = value;
    }

    /**
     * Gets the value of the copyJMSExpiration property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCopyJMSExpiration() {
        if (copyJMSExpiration == null) {
            return true;
        } else {
            return copyJMSExpiration;
        }
    }

    /**
     * Sets the value of the copyJMSExpiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCopyJMSExpiration(Boolean value) {
        this.copyJMSExpiration = value;
    }

    /**
     * Gets the value of the copyJMSReplyTo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCopyJMSReplyTo() {
        if (copyJMSReplyTo == null) {
            return true;
        } else {
            return copyJMSReplyTo;
        }
    }

    /**
     * Sets the value of the copyJMSReplyTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCopyJMSReplyTo(Boolean value) {
        this.copyJMSReplyTo = value;
    }

    /**
     * Gets the value of the copyJMSPriority property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCopyJMSPriority() {
        if (copyJMSPriority == null) {
            return true;
        } else {
            return copyJMSPriority;
        }
    }

    /**
     * Sets the value of the copyJMSPriority property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCopyJMSPriority(Boolean value) {
        this.copyJMSPriority = value;
    }

    /**
     * Gets the value of the embeddedMessageInBrowsePane property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isEmbeddedMessageInBrowsePane() {
        if (embeddedMessageInBrowsePane == null) {
            return false;
        } else {
            return embeddedMessageInBrowsePane;
        }
    }

    /**
     * Sets the value of the embeddedMessageInBrowsePane property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEmbeddedMessageInBrowsePane(Boolean value) {
        this.embeddedMessageInBrowsePane = value;
    }

    /**
     * Gets the value of the displayFactoryAdmin property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDisplayFactoryAdmin() {
        if (displayFactoryAdmin == null) {
            return false;
        } else {
            return displayFactoryAdmin;
        }
    }

    /**
     * Sets the value of the displayFactoryAdmin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisplayFactoryAdmin(Boolean value) {
        this.displayFactoryAdmin = value;
    }

    /**
     * Gets the value of the maxColumnsInStatisticsTable property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxColumnsInStatisticsTable() {
        return maxColumnsInStatisticsTable;
    }

    /**
     * Sets the value of the maxColumnsInStatisticsTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxColumnsInStatisticsTable(Integer value) {
        this.maxColumnsInStatisticsTable = value;
    }

    /**
     * Gets the value of the autoBrowseRefreshRate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAutoBrowseRefreshRate() {
        return autoBrowseRefreshRate;
    }

    /**
     * Sets the value of the autoBrowseRefreshRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAutoBrowseRefreshRate(Integer value) {
        this.autoBrowseRefreshRate = value;
    }

    /**
     * Gets the value of the correctDropSemantics property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCorrectDropSemantics() {
        if (correctDropSemantics == null) {
            return false;
        } else {
            return correctDropSemantics;
        }
    }

    /**
     * Sets the value of the correctDropSemantics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCorrectDropSemantics(Boolean value) {
        this.correctDropSemantics = value;
    }

    /**
     * Gets the value of the selectorImpl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectorImpl() {
        return selectorImpl;
    }

    /**
     * Sets the value of the selectorImpl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectorImpl(String value) {
        this.selectorImpl = value;
    }

    /**
     * Gets the value of the queueBrowseConsumerTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQueueBrowseConsumerTimeout() {
        return queueBrowseConsumerTimeout;
    }

    /**
     * Sets the value of the queueBrowseConsumerTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQueueBrowseConsumerTimeout(Long value) {
        this.queueBrowseConsumerTimeout = value;
    }

    /**
     * Gets the value of the enableJython property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isEnableJython() {
        if (enableJython == null) {
            return true;
        } else {
            return enableJython;
        }
    }

    /**
     * Sets the value of the enableJython property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnableJython(Boolean value) {
        this.enableJython = value;
    }

    /**
     * Gets the value of the lookAndFeel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLookAndFeel() {
        return lookAndFeel;
    }

    /**
     * Sets the value of the lookAndFeel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLookAndFeel(String value) {
        this.lookAndFeel = value;
    }

    /**
     * Gets the value of the messageStoreSession property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageStoreSession() {
        return messageStoreSession;
    }

    /**
     * Sets the value of the messageStoreSession property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageStoreSession(String value) {
        this.messageStoreSession = value;
    }

    /**
     * Gets the value of the scrollMessagesDuringBrowse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isScrollMessagesDuringBrowse() {
        if (scrollMessagesDuringBrowse == null) {
            return true;
        } else {
            return scrollMessagesDuringBrowse;
        }
    }

    /**
     * Sets the value of the scrollMessagesDuringBrowse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setScrollMessagesDuringBrowse(Boolean value) {
        this.scrollMessagesDuringBrowse = value;
    }

    /**
     * Gets the value of the deliveryModePersistent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDeliveryModePersistent() {
        if (deliveryModePersistent == null) {
            return true;
        } else {
            return deliveryModePersistent;
        }
    }

    /**
     * Sets the value of the deliveryModePersistent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeliveryModePersistent(Boolean value) {
        this.deliveryModePersistent = value;
    }

    /**
     * Gets the value of the base64EncodeMessages property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isBase64EncodeMessages() {
        if (base64EncodeMessages == null) {
            return true;
        } else {
            return base64EncodeMessages;
        }
    }

    /**
     * Sets the value of the base64EncodeMessages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBase64EncodeMessages(Boolean value) {
        this.base64EncodeMessages = value;
    }

    /**
     * Gets the value of the messageStoreMessageFactory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageStoreMessageFactory() {
        return messageStoreMessageFactory;
    }

    /**
     * Sets the value of the messageStoreMessageFactory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageStoreMessageFactory(String value) {
        this.messageStoreMessageFactory = value;
    }

    /**
     * Gets the value of the showDestinationsInMessageStore property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isShowDestinationsInMessageStore() {
        if (showDestinationsInMessageStore == null) {
            return false;
        } else {
            return showDestinationsInMessageStore;
        }
    }

    /**
     * Sets the value of the showDestinationsInMessageStore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowDestinationsInMessageStore(Boolean value) {
        this.showDestinationsInMessageStore = value;
    }

}
