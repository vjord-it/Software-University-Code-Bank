<?php


namespace Service\Message;


use Data\Message\Message;
use Data\Message\UnreadMessagesViewData;

interface MessageServiceInterface
{
    public function send($fromId, $toId, $message);

    public function getNewMessages($recipientId): UnreadMessagesViewData;

    public function findOne($id, $recipientId): Message;
    
    public function getSentMessages($senderId);
}