package samples.with.copy;

import java.util.Date;
import javax.annotation.Generated;
import samples.with.copy.Contact;

/**
 * The {@link ContactBuilder} is a Builder for {@link Contact} objects.
 *
 * <p>
 *     This class has been generated.
 *     Please DO NOT MODIFIY this file
 *     since it will be overwritten 
 *     by the PojoBuilder generator.
 * </p>
 */
@Generated("PojoBuilder")
public class ContactBuilder implements Cloneable {
	protected ContactBuilder self;
	protected String value$surname$java$lang$String; // mandatory constructor parameter
	protected boolean isSet$surname$java$lang$String = false; 

	protected Date value$birthdate$java$util$Date; 
	protected boolean isSet$birthdate$java$util$Date = false; 

	protected String value$firstname$java$lang$String; 
	protected boolean isSet$firstname$java$lang$String = false; 

	protected String value$email$java$lang$String; 
	protected boolean isSet$email$java$lang$String = false; 



	/**
	 * Creates a new {@link ContactBuilder}.
	 */
	public ContactBuilder() {
		self = (ContactBuilder)this;
	}

	/**
	 * Sets the default value for the {@link Contact#surname} property.
	 * @param value the default value
	 * @return this builder
	 */
	public ContactBuilder withSurname( String value) {
		this.value$surname$java$lang$String = value;
		this.isSet$surname$java$lang$String = true;
		return self;
	}
	/**
	 * Sets the default value for the {@link Contact#birthdate} property.
	 * @param value the default value
	 * @return this builder
	 */
	public ContactBuilder withBirthdate( Date value) {
		this.value$birthdate$java$util$Date = value;
		this.isSet$birthdate$java$util$Date = true;
		return self;
	}
	/**
	 * Sets the default value for the {@link Contact#firstname} property.
	 * @param value the default value
	 * @return this builder
	 */
	public ContactBuilder withFirstname( String value) {
		this.value$firstname$java$lang$String = value;
		this.isSet$firstname$java$lang$String = true;
		return self;
	}
	/**
	 * Sets the default value for the {@link Contact#email} property.
	 * @param value the default value
	 * @return this builder
	 */
	public ContactBuilder withEmail( String value) {
		this.value$email$java$lang$String = value;
		this.isSet$email$java$lang$String = true;
		return self;
	}


	/**
	 * Returns a clone of this builder.
	 * @return the clone
	 */
	@Override	
	public Object clone() {
		try {
			ContactBuilder result = (ContactBuilder)super.clone();
			result.self = result;
			return result;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}        
	}

	/**
	 * Returns a clone of this builder.
	 * @return the clone
	 */
	public ContactBuilder but() {
		return (ContactBuilder)clone();
	}

	/**
	 * Creates a new {@link Contact} based on this builder's settings.
	 * @return the created Contact
	 */
	public Contact build() {
		Contact result = new Contact( this.value$surname$java$lang$String );

		if ( this.isSet$birthdate$java$util$Date) { 
			result.birthdate = this.value$birthdate$java$util$Date;	
		}
		if ( this.isSet$firstname$java$lang$String) { 
			result.firstname = this.value$firstname$java$lang$String;	
		}
		if ( this.isSet$email$java$lang$String) { 
			result.email = this.value$email$java$lang$String;	
		}

		return result;
	}

	/**
 	* Copies properties from <i>original</i> into the builder
 	* @param original the object to be copied
 	* @return this builder
 	*/
	public ContactBuilder copy(Contact original) {
		this.withBirthdate(original.birthdate);
		this.withFirstname(original.firstname);
		this.withEmail(original.email);

		return self;
	}
}