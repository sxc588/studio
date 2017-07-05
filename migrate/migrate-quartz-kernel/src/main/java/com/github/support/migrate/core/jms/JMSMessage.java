package com.github.support.migrate.core.jms;

import java.io.Serializable;

public class JMSMessage implements Serializable
{
	public JMSMessage(String oldBean,
	String newBean,
	JMSEvent event)
	{
		super();
		this.oldBean = oldBean;
		this.newBean = oldBean;
		this.event = event;
	}
	enum  JMSEvent
	{
		CREATE(1),
		UPDATE(2),
		REMOVE(3);
		
		private int type;

		public int getType()
		{
			return this.type;
		}
		JMSEvent(int type)
		{
			this.type = type;
		}
	}

	private static final long serialVersionUID = 978578308345568187L;

	JMSEvent event;
	String oldBean;
	String newBean;
}
