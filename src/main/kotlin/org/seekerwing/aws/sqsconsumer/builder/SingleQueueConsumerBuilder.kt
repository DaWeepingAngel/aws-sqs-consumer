package org.seekerwing.aws.sqsconsumer.builder

import org.seekerwing.aws.sqsconsumer.QueueConsumer
import org.seekerwing.aws.sqsconsumer.configuration.ConsumerConfiguration
import org.seekerwing.aws.sqsconsumer.configuration.MessageProviderConfiguration
import org.seekerwing.aws.sqsconsumer.messageprovider.MessageProvider
import org.seekerwing.aws.sqsconsumer.messageprovider.SingleQueueBasedMessageProvider

/**
 * Implementation of [QueueConsumerBuilder] to be used by user of the library to build an instance of [QueueConsumer]
 * that is configured to poll a single queue and invoke the
 * [MessageProcessor][org.seekerwing.aws.sqsconsumer.MessageProcessor] implemented by the user of the library. The
 * builder needs [MessageProviderConfiguration] to instantiate [QueueConsumer] and can optionally accept
 * [ConsumerConfiguration].
 */
class SingleQueueConsumerBuilder(
    private val messageProviderConfiguration: MessageProviderConfiguration,
    private val consumerConfiguration: ConsumerConfiguration = ConsumerConfiguration()
) : AbstractQueueConsumerBuilder(consumerConfiguration) {

    override fun messageProvider(): MessageProvider = SingleQueueBasedMessageProvider(messageProviderConfiguration)
}
