FROM mcr.microsoft.com/devcontainers/java:1-21-bookworm

# Install Node.js and npm for the Next.js app
RUN apt-get update \
    && apt-get install -y --no-install-recommends nodejs npm \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*
