<?php
class Office
{
    public function writeDocument($document, Writer $writer)
    {
        $writer->write($document);
    }
}

class Closet
{
    /**
     * @var Machine
     */
    private $machine;

    public function changePart(Machine $machine, $part)
    {
        $this->machine = $machine;

        if ($machine->getPart($part)) {
            $machine->setPart($part);
        }
    }
}

interface Writer
{
    public function write($text);
}

interface Machine
{
    public function getParts();

    public function getPart($part);

    public function setPart($part);
}

class Pen implements Writer
{
    private $ink;

    public function __construct($ink)
    {
        $this->ink = $ink;
    }

    public function write($text)
    {
        for ($i = 0; $i < strlen($text); $i++) {
            echo $text[$i];
            $this->ink--;
            if ($this->ink == 0) {
                echo "<br/>";
                return;
            }
        }
        echo "<br/>";
    }
}

class TypeWriter implements Writer, Machine
{
    private $paper;

    private $parts = ['head', 'keyboard'];

    public function __construct($paper)
    {
        $this->paper = $paper;
    }


    public function write($text)
    {
        for ($i = 0; $i < strlen($text); $i++) {
            echo $text[$i];
            if ($text[$i] == ' ') {
                $this->paper--;
                if ($this->paper == 0) {
                    echo "<br/>";
                    return;
                }
            }
        }
        echo "<br/>";
    }

    public function getParts()
    {
        return $this->parts;
    }

    public function getPart($part)
    {
        return in_array($part, $this->getParts());
    }

    public function setPart($part)
    {
        foreach ($this->parts as $key => $partFromArray) {
            if ($partFromArray = $part) {
                echo "Smenihme $part <br/>";
            }
        }
    }
}

class Printer implements Writer, Machine
{

    private $parts = ['laser'];

    public function write($text)
    {
        echo $text . "<br/>";
    }

    public function getParts()
    {
        return $this->parts;
    }

    public function getPart($part)
    {
        return in_array($part, $this->getParts());
    }

    public function setPart($part)
    {
        foreach ($this->parts as $key => $partFromArray) {
            if ($partFromArray = $part) {
                echo "Changed printer's $part <br/>";
            }
        }
    }
}

class Car implements Machine
{

    private $parts = ['engine'];

    public function getParts()
    {
        return $this->parts;
    }

    public function getPart($part)
    {
        return in_array($part, $this->getParts());
    }

    public function setPart($part)
    {
        foreach ($this->parts as $key => $partFromArray) {
            if ($partFromArray = $part) {
                echo "Na kolata smenihme $part <br/>";
            }
        }
    }
}

$office = new Office();
$office->writeDocument("tova e dokumenta na pesho", new Printer());

$closet = new Closet();
$closet->changePart(new Car(13), "engine");