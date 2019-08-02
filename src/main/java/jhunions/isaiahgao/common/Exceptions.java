package jhunions.isaiahgao.common;

public class Exceptions {
	
	public static class NoSuchRoomException extends Exception {

		private static final long serialVersionUID = -8726040829442542464L;
		
	}
	
	public static class NoSuchUserException extends Exception {

		private static final long serialVersionUID = -872260408294422464L;
		
	}
	
	public static class AuthenticationFailedException extends Exception {

		private static final long serialVersionUID = 7379205881588301229L;
		
	}
	
	public static class InvalidSyntaxException extends Exception {

		private static final long serialVersionUID = 7952672410855300755L;
		
	}

}
