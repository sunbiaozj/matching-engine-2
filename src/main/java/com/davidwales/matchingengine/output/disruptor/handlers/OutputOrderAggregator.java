package com.davidwales.matchingengine.output.disruptor.handlers;

import java.net.UnknownHostException;

import com.davidwales.matchingengine.output.disruptor.OrderOutputEvent;
import com.davidwales.matchingengine.output.disruptor.handlers.aggregators.AggregatorTranslator;
import com.lmax.disruptor.EventHandler;

public class OutputOrderAggregator implements EventHandler<OrderOutputEvent>  
{
	
	AggregatorTranslator aggregatorTranslator;
	
	public OutputOrderAggregator(AggregatorTranslator aggregatorTranslator) throws UnknownHostException
	{
		this.aggregatorTranslator = aggregatorTranslator;
	}
	
	
	@Override
	public void onEvent(OrderOutputEvent event, long sequence, boolean endOfBatch) throws Exception 
	{
		aggregatorTranslator.aggregateOrder(event.getExecutedOrder());
	}

}