#!/bin/bash

 for i in $(eval echo {$1..$2})
 do 
  curl -i -H -X "http://localhost:9000/hotel/details/$i" 
done
