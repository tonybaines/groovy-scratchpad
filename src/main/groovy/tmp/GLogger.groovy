package tmp
import groovy.lang.Delegate;
import java.util.logging.Level
import java.util.logging.Logger;


public class GLogger {
	@Delegate Logger logger
	public static GLogger getLogger(Class c) {
		getLogger(c.name)
	}
	public static GLogger getLogger(String name) {
        new GLogger(Logger.getLogger(name))
    }
	
	private GLogger(delegate) {
		this.logger = delegate
	}

	// Expose proper log methods which accept exceptions
	def methodMissing(String name, args) {
		Level level = Level.parse(name.toUpperCase())
		switch (args.length) {
        case 1: 
			this.logger.log(level, args[0]) 
        	break
        case 2:
			this.logger.log(level, args[0], args[1])
			break
		default: 
			throw new MissingMethodException(name, args)
		}
	}

}
