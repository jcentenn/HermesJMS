//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.09.27 at 12:37:15 BST 
//


package hermes.config.impl;

public class ClasspathConfigImpl implements hermes.config.ClasspathConfig, com.sun.xml.bind.JAXBObject, hermes.config.impl.runtime.UnmarshallableObject, hermes.config.impl.runtime.XMLSerializable, hermes.config.impl.runtime.ValidatableObject
{

    protected java.lang.String _Factories;
    protected java.lang.String _Jar;
    protected boolean has_NoFactories;
    protected boolean _NoFactories;
    public final static java.lang.Class version = (hermes.config.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (hermes.config.ClasspathConfig.class);
    }

    public java.lang.String getFactories() {
        return _Factories;
    }

    public void setFactories(java.lang.String value) {
        _Factories = value;
    }

    public java.lang.String getJar() {
        return _Jar;
    }

    public void setJar(java.lang.String value) {
        _Jar = value;
    }

    public boolean isNoFactories() {
        return _NoFactories;
    }

    public void setNoFactories(boolean value) {
        _NoFactories = value;
        has_NoFactories = true;
    }

    public hermes.config.impl.runtime.UnmarshallingEventHandler createUnmarshaller(hermes.config.impl.runtime.UnmarshallingContext context) {
        return new hermes.config.impl.ClasspathConfigImpl.Unmarshaller(context);
    }

    public void serializeBody(hermes.config.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public void serializeAttributes(hermes.config.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (_Factories!= null) {
            context.startAttribute("", "factories");
            try {
                context.text(((java.lang.String) _Factories), "Factories");
            } catch (java.lang.Exception e) {
                hermes.config.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endAttribute();
        }
        if (_Jar!= null) {
            context.startAttribute("", "jar");
            try {
                context.text(((java.lang.String) _Jar), "Jar");
            } catch (java.lang.Exception e) {
                hermes.config.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endAttribute();
        }
        if (has_NoFactories) {
            context.startAttribute("", "noFactories");
            try {
                context.text(javax.xml.bind.DatatypeConverter.printBoolean(((boolean) _NoFactories)), "NoFactories");
            } catch (java.lang.Exception e) {
                hermes.config.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endAttribute();
        }
    }

    public void serializeURIs(hermes.config.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public java.lang.Class getPrimaryInterface() {
        return (hermes.config.ClasspathConfig.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.su"
+"n.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/gra"
+"mmar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expressi"
+"on\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000b"
+"expandedExpq\u0000~\u0000\u0002xpppsq\u0000~\u0000\u0000ppsr\u0000\u001dcom.sun.msv.grammar.ChoiceEx"
+"p\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001ppsr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameCl"
+"ass;xq\u0000~\u0000\u0003sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psr\u0000\u001bco"
+"m.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/dat"
+"atype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0002L\u0000\u0004namet\u0000\u001dLcom/sun/msv/util/Str"
+"ingPair;xq\u0000~\u0000\u0003ppsr\u0000#com.sun.msv.datatype.xsd.StringType\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0001\u0002\u0000\u0001Z\u0000\risAlwaysValidxr\u0000*com.sun.msv.datatype.xsd.BuiltinAt"
+"omicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.ConcreteType"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/String;L\u0000\btypeNameq\u0000~\u0000\u0016L\u0000\n"
+"whiteSpacet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpaceProcessor;x"
+"pt\u0000 http://www.w3.org/2001/XMLSchemat\u0000\u0006stringsr\u00005com.sun.msv"
+".datatype.xsd.WhiteSpaceProcessor$Preserve\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com"
+".sun.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xp\u0001sr\u00000c"
+"om.sun.msv.grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq"
+"\u0000~\u0000\u0003ppsr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalName"
+"q\u0000~\u0000\u0016L\u0000\fnamespaceURIq\u0000~\u0000\u0016xpq\u0000~\u0000\u001aq\u0000~\u0000\u0019sr\u0000#com.sun.msv.grammar"
+".SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0016L\u0000\fnamespaceURIq"
+"\u0000~\u0000\u0016xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\tfactori"
+"est\u0000\u0000sr\u00000com.sun.msv.grammar.Expression$EpsilonExpression\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003sq\u0000~\u0000\f\u0001psq\u0000~\u0000\u0007ppsq\u0000~\u0000\tq\u0000~\u0000\rpq\u0000~\u0000\u0011sq\u0000~\u0000\"t\u0000\u0003jarq"
+"\u0000~\u0000&q\u0000~\u0000(sq\u0000~\u0000\u0007ppsq\u0000~\u0000\tq\u0000~\u0000\rpsq\u0000~\u0000\u000eppsr\u0000$com.sun.msv.datatyp"
+"e.xsd.BooleanType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0013q\u0000~\u0000\u0019t\u0000\u0007booleansr\u00005com.sun"
+".msv.datatype.xsd.WhiteSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000"
+"~\u0000\u001cq\u0000~\u0000\u001fsq\u0000~\u0000 q\u0000~\u00003q\u0000~\u0000\u0019sq\u0000~\u0000\"t\u0000\u000bnoFactoriesq\u0000~\u0000&q\u0000~\u0000(sr\u0000\"co"
+"m.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lco"
+"m/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.ms"
+"v.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB\u0000\rstr"
+"eamVersionL\u0000\u0006parentt\u0000$Lcom/sun/msv/grammar/ExpressionPool;xp"
+"\u0000\u0000\u0000\u0005\u0001pq\u0000~\u0000\bq\u0000~\u0000.q\u0000~\u0000*q\u0000~\u0000\u0005q\u0000~\u0000\u0006x"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends hermes.config.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(hermes.config.impl.runtime.UnmarshallingContext context) {
            super(context, "----------");
        }

        protected Unmarshaller(hermes.config.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return hermes.config.impl.ClasspathConfigImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  6 :
                        attIdx = context.getAttribute("", "noFactories");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText1(v);
                            state = 9;
                            continue outer;
                        }
                        state = 9;
                        continue outer;
                    case  3 :
                        attIdx = context.getAttribute("", "jar");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText2(v);
                            state = 6;
                            continue outer;
                        }
                        state = 6;
                        continue outer;
                    case  9 :
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                    case  0 :
                        attIdx = context.getAttribute("", "factories");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText3(v);
                            state = 3;
                            continue outer;
                        }
                        state = 3;
                        continue outer;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        private void eatText1(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _NoFactories = javax.xml.bind.DatatypeConverter.parseBoolean(com.sun.xml.bind.WhiteSpaceProcessor.collapse(value));
                has_NoFactories = true;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText2(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _Jar = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText3(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _Factories = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  6 :
                        attIdx = context.getAttribute("", "noFactories");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText1(v);
                            state = 9;
                            continue outer;
                        }
                        state = 9;
                        continue outer;
                    case  3 :
                        attIdx = context.getAttribute("", "jar");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText2(v);
                            state = 6;
                            continue outer;
                        }
                        state = 6;
                        continue outer;
                    case  9 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  0 :
                        attIdx = context.getAttribute("", "factories");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText3(v);
                            state = 3;
                            continue outer;
                        }
                        state = 3;
                        continue outer;
                }
                super.leaveElement(___uri, ___local, ___qname);
                break;
            }
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  6 :
                        if (("noFactories" == ___local)&&("" == ___uri)) {
                            state = 7;
                            return ;
                        }
                        state = 9;
                        continue outer;
                    case  3 :
                        if (("jar" == ___local)&&("" == ___uri)) {
                            state = 4;
                            return ;
                        }
                        state = 6;
                        continue outer;
                    case  9 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                    case  0 :
                        if (("factories" == ___local)&&("" == ___uri)) {
                            state = 1;
                            return ;
                        }
                        state = 3;
                        continue outer;
                }
                super.enterAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  8 :
                        if (("noFactories" == ___local)&&("" == ___uri)) {
                            state = 9;
                            return ;
                        }
                        break;
                    case  6 :
                        attIdx = context.getAttribute("", "noFactories");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText1(v);
                            state = 9;
                            continue outer;
                        }
                        state = 9;
                        continue outer;
                    case  3 :
                        attIdx = context.getAttribute("", "jar");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText2(v);
                            state = 6;
                            continue outer;
                        }
                        state = 6;
                        continue outer;
                    case  5 :
                        if (("jar" == ___local)&&("" == ___uri)) {
                            state = 6;
                            return ;
                        }
                        break;
                    case  2 :
                        if (("factories" == ___local)&&("" == ___uri)) {
                            state = 3;
                            return ;
                        }
                        break;
                    case  9 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                    case  0 :
                        attIdx = context.getAttribute("", "factories");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText3(v);
                            state = 3;
                            continue outer;
                        }
                        state = 3;
                        continue outer;
                }
                super.leaveAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void handleText(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                try {
                    switch (state) {
                        case  4 :
                            eatText2(value);
                            state = 5;
                            return ;
                        case  6 :
                            attIdx = context.getAttribute("", "noFactories");
                            if (attIdx >= 0) {
                                final java.lang.String v = context.eatAttribute(attIdx);
                                eatText1(v);
                                state = 9;
                                continue outer;
                            }
                            state = 9;
                            continue outer;
                        case  7 :
                            eatText1(value);
                            state = 8;
                            return ;
                        case  3 :
                            attIdx = context.getAttribute("", "jar");
                            if (attIdx >= 0) {
                                final java.lang.String v = context.eatAttribute(attIdx);
                                eatText2(v);
                                state = 6;
                                continue outer;
                            }
                            state = 6;
                            continue outer;
                        case  1 :
                            eatText3(value);
                            state = 2;
                            return ;
                        case  9 :
                            revertToParentFromText(value);
                            return ;
                        case  0 :
                            attIdx = context.getAttribute("", "factories");
                            if (attIdx >= 0) {
                                final java.lang.String v = context.eatAttribute(attIdx);
                                eatText3(v);
                                state = 3;
                                continue outer;
                            }
                            state = 3;
                            continue outer;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

    }

}
