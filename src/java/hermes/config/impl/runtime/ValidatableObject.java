//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.01.03 at 11:55:46 GMT 
//

package hermes.config.impl.runtime;

import com.sun.msv.verifier.DocumentDeclaration;

/**
 * This interface is implemented by generated classes
 * to indicate that the class supports validation.
 */
public interface ValidatableObject extends XMLSerializable
{
    /** Gets the schema fragment associated with this class. */
    DocumentDeclaration createRawValidator();
    
    /**
     * Gets the main interface that this object implements.
     * 
     * For example, <code>FooImpl</code> will return <code>Foo</code>
     * from this method.
     */
    Class getPrimaryInterface();
}
