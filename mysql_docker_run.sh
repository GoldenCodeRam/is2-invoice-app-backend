# As the data has to be as isolated as possible, the MySQL container will use
# A mounted folder; datadir.

# If the datadir for the MySQL container does not exist, then create it.
DATADIR_PATH="$(pwd)/datadir"
if [ ! -d $DATADIR_PATH ]; then
    mkdir $DATADIR_PATH
fi

# Run the container.
sudo docker run --rm -v $DATADIR_PATH:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password mysql