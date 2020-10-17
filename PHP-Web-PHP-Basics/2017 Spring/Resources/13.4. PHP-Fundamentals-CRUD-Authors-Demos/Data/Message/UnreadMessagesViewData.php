<?php


namespace Data\Message;


class UnreadMessagesViewData
{
    /**
     * @var Message[]|\Generator
     */
    private $messages;

    /**
     * @return Message[]|\Generator
     */
    public function getMessages()
    {
        return $this->messages;
    }

    /**
     * @param callable $messages
     */
    public function setMessages(callable $messages)
    {
        $this->messages = $messages();
    }


}