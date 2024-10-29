package example.org;

public class MsgQuantityReader implements IElementReader<Integer> {
    private final ICustomPrompt prompt;

    public MsgQuantityReader(ICustomPrompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public Integer read() {
        return prompt.getInt("Enter the quantity: ");
    }
}

