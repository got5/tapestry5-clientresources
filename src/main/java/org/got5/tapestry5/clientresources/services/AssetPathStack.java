package org.got5.tapestry5.clientresources.services;

/**
 * Stores a stack of assets. It makes {@link ContribuableClientInfrastructure} configuration easier 
 */
public class AssetPathStack
{
    private String[] stack;

    public AssetPathStack()
    {
    };

    public AssetPathStack(String... stack)
    {
	this.stack = stack;
    }

    public String[] getStack()
    {
	return stack;
    }

    public void setStack(String[] stack)
    {
	System.arraycopy(stack, 0, this.stack, 0, stack.length);
    }

}
