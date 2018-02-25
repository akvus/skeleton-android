<?php
# empty messages.json: {"messages":[]}
$action = $_GET['action'];
$nickname = $_GET['nickname'];
$message = $_GET['message'];
$token = $_GET['token'];

if ($nickname != 'Bob' && $nickname != 'Alice') {
    echo '{"error": 1, "messages":[]}';
    exit;
} elseif ($action != 'add' && $action != 'get') {
    echo '{"error": 2, "messages":[]}';
    exit;
} elseif ($token != 'testToken') {
    echo '{"error": 3, "messages":[]}';
    exit;
} elseif ($action == 'add' && empty($message)) {
    echo '{"error":4, "messages":[]}';
    exit;
}

$jsonFileName = './messages.json';
$messagesFile = file_get_contents($jsonFileName, FILE_USE_INCLUDE_PATH);
$messagesJson = json_decode($messagesFile, true);
if ($action == 'add') {
    $messagesJson['messages'][] = array('nickname' => $nickname, 'message' => $message, 'timestamp' => time());
    echo '{"error":0, "messages":[]}';
} else {
    $resultMessages = array();
    foreach ($messagesJson['messages'] as $key => $message) {
        if ($message['nickname'] != $nickname) {
            $resultMessages[] = $message;
            unset($messagesJson['messages'][$key]);
        }
    }
    echo json_encode(array('error' => 0, 'messages' => $resultMessages));
}
file_put_contents($jsonFileName, json_encode($messagesJson));
