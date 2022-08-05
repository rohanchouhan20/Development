public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
    class StockException extends RuntimeException{
    public StockException(String message){
        super(message);
    }
}
    class BrandException extends RuntimeException{
    public BrandException(String message){
        super(message);
    }}
class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message){
        super(message);
    }}

