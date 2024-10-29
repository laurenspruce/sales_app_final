package example.org;

public class MsgVATReader implements IElementReader<Double> {
    private final ICustomPrompt prompt;

    public MsgVATReader(ICustomPrompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public Double read() {
        return prompt.getDouble("Enter the VAT rate: ");
    }
}

