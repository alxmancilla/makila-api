# Mstore: Dellstore Migration to MongoDB

Our project Mstore: Dellstore Migration to MongoDB focuses on highlighting the customer journey who replace their relational databases with MongoDB. When we engage with Replace use cases, determining that MongoDB is a suitable database is only the first step to consumption. The next step is to set up MongoDB and migrate data. This step is often confusing for customers who come from a relational background. Our project aims to highlight this journey by migrating the Sakila database onto MongoDB, creating an API that can use both Postgres and MongoDB data layers, and finally load testing both implementations of the data layer. Through this, our team demonstrates not only the viability of MongoDB as a replacement for relational databases but also the enhancements that utilizing MongoDB brings.

We chose Dellstore as the database to migrate because it models a well known business model, dvd rentals. By focusing on migrating the Dellstore, customers will see that established business models can be adequately modeled with MongoDB.

While Migrating Dellstore to MongoDB, we ran into a variety of bumps along the way. We found that developing with Postgres is much harder than working with MongoDB. Not only was deploying a Postgres database much harder, but Postgres APIs were also much harder to implement than MongoDB APIs. The majority of our time was spent working with Postgres. This indicates that developer productivity is much greater with MongoDB.


## Pre-requirements

Create a multi cluster for Postgres using AWS RDS. 3 instances deployed in multiple AZ. See [Creating a Multi-AZ DB cluster for Amazon RDS](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/create-multi-az-db-cluster.html)
 
Create a 3-member replica set deployed in a single region cluster using MongoDB Atlas in AWS. See [Create a Cluster](https://www.mongodb.com/docs/atlas/tutorial/create-new-cluster/)

Download dataset from [Dell DVD Store Database Test Suite](https://linux.dell.com/dvdstore/)

wget https://linux.dell.com/dvdstore/ds21_postgresql.tar.gz
or
curl -O https://linux.dell.com/dvdstore/ds21_postgresql.tar.gz

Install Relational Migrator. See [Relationa Migrator installation guide](https://www.mongodb.com/docs/relational-migrator/installation/)


## Instructions

Clone this repository:

git clone 



Build jar file


